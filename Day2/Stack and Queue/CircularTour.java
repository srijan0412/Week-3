class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {
    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0, end = 0;
        int currentSurplus = 0, totalSurplus = 0;

        for (int i = 0; i < pumps.length; i++) {
            totalSurplus += pumps[i].petrol - pumps[i].distance;
            currentSurplus += pumps[i].petrol - pumps[i].distance;
            
            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }
        
        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };
        
        int start = findStartingPoint(pumps);
        if (start == -1) {
            System.out.println("No circular tour possible");
        } else {
            System.out.println("Start at petrol pump: " + start);
        }
    }
}
