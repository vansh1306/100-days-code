class Solution {
    public String getHint(String secret, String guess) {
        int cows = 0;
        int bulls  = 0;
        Map<Character,Integer> sec = new HashMap<>();
        Map<Character,Integer> gue = new HashMap<>();// Pehle humne hashmap bnaya jisme hum store krege apni value .

        for(int i = 0; i < secret.length(); i++){
            char s = secret.charAt(i); // secret keys ke chactater
            char g = guess.charAt(i); // guess keys ke character

            if(s == g){ // agr dono charcater ki position wise wo match hoge to matlab wo bulls h
                bulls++;
            }
            else{ // otherwise unko hashmmap me dal dege for checking cows
                sec.put(s,sec.getOrDefault(s,0) +1);
                gue.put(g,gue.getOrDefault(g,0) +1);
            }
        }

        for(char c : sec.keySet()){ //secret keys ke hashmap m saare character check krege ki agr guess wali m koi b match krta h to wo cow h
            if(gue.containsKey(c)){
                cows += Math.min(sec.get(c),gue.get(c));
            }
        }
        return bulls + "A" + cows + "B"; // output 
    }
}