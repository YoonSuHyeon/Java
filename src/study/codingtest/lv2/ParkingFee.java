package study.codingtest.lv2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 주차 요금 계산
 * fees : 기본 시간(분), 기본요금 , 단위 시간(분), 단위 요금
 * records : 시각(시:분) , 차량 번호, 내역(입차,출차)
 * 차량이 입차된 후에 출차된 내역이 없다면 23:59에 출차된 것으로 간주
 * 초과한 시간이 단위 시간으로 나우어 떨어지지 않으면 올림을 한다.
 */
public class ParkingFee {

    private static class Parking {
        private int minute;
        private String number;
        private Type type;

        Parking(String minute, String number, String type) {
            String[] split = minute.split(":");
            int hour = Integer.parseInt(split[0]) * 60;
            int minute1 = Integer.parseInt(split[1]);
            this.minute = hour + minute1;
            this.number = number;
            this.type = Type.valueOf(type);
        }

        public String getNumber() {
            return number;
        }

        public int getMinute() {
            return minute;
        }
    }

    private enum Type {
        IN, OUT
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Parking>> collect = Arrays.stream(records).map(r -> {
            String[] split = r.split(" ");
            return new Parking(split[0], split[1], split[2]);
        }).collect(Collectors.groupingBy(Parking::getNumber));

        return collect.keySet().stream().sorted().mapToInt(s -> getPrice(fees,collect.get(s))).toArray();
    }

    private int getPrice(int[] fees, List<Parking> parking) {
        String number = parking.get(0).getNumber();
        if (parking.size() % 2 == 1)
            parking.add(new Parking("23:59", number, "OUT"));

        int totalTime = 0;
        for (int i = 0; i < parking.size(); i += 2) {
            int parkTime = parking.get(i + 1).getMinute() - parking.get(i).getMinute();
            totalTime = totalTime + parkTime;
        }

        int round = (int) Math.ceil((double) (totalTime - fees[0]) / fees[2]);
        return totalTime <= fees[0] ? fees[1] : fees[1] + round * fees[3];

    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        ParkingFee parkingFee = new ParkingFee();
        int[] solution = parkingFee.solution(fees, records);

        Arrays.stream(solution).forEach(System.out::println);
    }
}
