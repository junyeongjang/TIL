class Solution {
    public int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        for(int i=0;i<gift_cards.length;i++){
            if(gift_cards[i]==wants[i]) continue;
            for(int j=i+1;j<gift_cards.length;j++){
                if(wants[i] == gift_cards[j]){
                    int temp = gift_cards[j];
                    gift_cards[j] = gift_cards[i];
                    gift_cards[i] = temp;
                    break;
                }
            }
        }
        for(int i=0;i<gift_cards.length;i++){
            if(gift_cards[i] != wants[i]) answer++;
        }

        return answer;
    }
}