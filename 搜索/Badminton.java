package 搜索;

import java.util.*;

public class Badminton {

    public static void main(String[] args) {
        String[] teamA = {"a1", "a2", "a3", "a4", "a5"};
        String[] teamB = {"b1", "b2", "b3", "b4", "b5"};

        String[] count = new String[3];
        List<String> total = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < teamA.length; i++) {
            for (int j = 0; j < teamB.length; j++) {
                total.add(teamA[i] + " vs " + teamB[j]);
            }
        }

        List<List<String>> game = new ArrayList<>();
        Random rnd = new Random();
        System.out.println(total);
        int mark = 0;
        List<String> rest = new ArrayList<>();
        List<String> r = new ArrayList<>();
        HashMap<Integer, List<String>> res = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> last = new HashMap<>();
        for (int i = 0; i < teamA.length; i++) {
            r.add(teamA[i]);

            map.put(teamA[i], 0);
            last.put(teamA[i], 0);
//            map.put(teamA[i], rnd.nextInt(2));
        }
        for (int i = 0; i < teamB.length; i++) {
            r.add(teamB[i]);
            map.put(teamB[i], 0);
            last.put(teamB[i], 0);
//            map.put(teamB[i], rnd.nextInt(2));
        }
        res.put(0, r);
        res.put(0, rest);
        while (!total.isEmpty()) {
            List<String> round = new ArrayList<>();
            while (round.size() < 3) {
                if (total.size() == 0)
                    break;
                mark = rnd.nextInt(total.size());
                for (int i = 0; i < round.size(); i++) {
                    mark = rnd.nextInt(total.size());

                    String vs = total.get(mark).split(" vs ")[0];

                    String vsTo = total.get(mark).split(" vs ")[1];
                    System.out.println("vs vsTo " + vs + "\t" + vsTo);

                    while (round.get(i).contains(vs) || round.get(i).endsWith(vsTo)
                    ) {
                        mark = rnd.nextInt(total.size());
                        vs = total.get(mark).split(" vs ")[0];
                        vsTo = total.get(mark).split(" vs ")[1];

                    }


                }
                System.out.println(mark + "\t" + total.size());
                String vs = total.get(mark).split(" vs ")[0];

                String vsTo = total.get(mark).split(" vs ")[1];

                vs = total.get(mark).split(" vs ")[0];

                vsTo = total.get(mark).split(" vs ")[1];

                Integer vs1 = map.get(vs);
                Integer vsT = map.get(vsTo);


//                if (last.get(vs) == 1 && vs1 == 0)
//                    map.put(vs, 1);
//                if (last.get(vsTo) == 1 && vsT == 0)
//                    map.put(vsTo, 1);

                round.add(total.get(mark));


//                System.out.println(total.get(mark));
                total.remove(mark);
            }
            game.add(new ArrayList<>(round));
            for (int i = 0; i < round.size(); i++) {

                for (Map.Entry<String, Integer> m : last.entrySet()) {
                    String tmp = m.getKey();
                    last.put(tmp, 0);
                }
                last.put(round.get(i).split(" vs ")[0], 1);
                last.put(round.get(i).split(" vs ")[1], 1);
            }
        }
        game.forEach(System.out::println);


    }
}
