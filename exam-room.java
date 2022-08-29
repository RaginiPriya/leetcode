class ExamRoom {
    
    // 6
    // 0 1 2 3 4 5
    
    int noOfSeats;
    List<Integer> seats;

    public ExamRoom(int n) {
        noOfSeats = n;
        seats = new ArrayList<Integer>();
    }
    
    public int seat() {
        
        if(seats.isEmpty()){
            seats.add(0);
            return 0;
        }
        
        // 0 to first and last to noOfSeats
        // add at first or add at last
        int dist = Math.max(seats.get(0), noOfSeats - seats.get(seats.size() - 1) - 1);
        
        // add in between
        for(int i = 0; i < seats.size() - 1; i++){
            dist = Math.max(dist, (seats.get(i + 1) - seats.get(i)) / 2);
        }
        
        if(seats.get(0) == dist){
            seats.add(0, 0);
            return 0;
        }
        
        for(int i = 0; i < seats.size() - 1; i++){
            if(dist == (seats.get(i + 1) - seats.get(i)) / 2){
                seats.add(i + 1, seats.get(i) + dist);
                return seats.get(i + 1);
            }           
        }
        
        seats.add(noOfSeats - 1);
        return noOfSeats - 1;
    }
    
    public void leave(int p) {
        for(int i = 0; i < seats.size(); i++){
            if(seats.get(i) == p){
                seats.remove(i);
            }
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */