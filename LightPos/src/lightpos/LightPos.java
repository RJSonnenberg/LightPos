/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lightpos;

/**
 *
 * @author reube
 */
public class LightPos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numParents = 30;
        int numOffspring = 250;
        double mutationInitialStepSize = 1;
        int terminationCount = 10000000;
        int n = 8; //number of lights
        int roomWidth = 120; //inches
        int roomLength = 180; // inches
        //int optimalLightHeight = 36; // inches (Not currently implemented
        
        LightPos_API myApi = new LightPos_API(numParents, numOffspring, n, 
                roomWidth, roomLength, 
                mutationInitialStepSize, terminationCount);
        light[] bestSolution = myApi.getBestSolution();
        System.out.println("Best solution for " + roomWidth + "\"x" + 
                roomLength +"\" room: {");
        for (int i = 0; i < bestSolution.length; i++) {
            // If the light is on and contributes to the solution
            if (bestSolution[i].isOn())
            {
                System.out.print("Light " + (i+1) + ": ");
                System.out.print("x=" + bestSolution[i].getPos_x());
                System.out.print("\t y=" + bestSolution[i].getPos_y());
                System.out.println("\t W=" + bestSolution[i].getWatts());
            }
        }
        System.out.println("} = " + myApi.getFitness(bestSolution));
    }
    
}
