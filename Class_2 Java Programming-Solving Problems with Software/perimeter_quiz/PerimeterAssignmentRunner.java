import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;        
        // Start wth prevPt = the last point         
        Point prevPt = s.getLastPoint();        
        // For each point currPt in the shape,       
        for (Point currPt : s.getPoints()) {            
            // Find distance from prevPt point to currPt             
            double currDist = prevPt.distance(currPt);            
            // Update totalPerim by currDist            
            totalPerim = totalPerim + currDist;            
            // Update prevPt to be currPt            
            prevPt = currPt;        
        }
            // totalPerim is the answer        
            return totalPerim;    
        }    
    public int getNumPoints (Shape s) {        
        // Put code here        
        int count = 0;                
        for(Point pt : s.getPoints()){
            count++;        
        }        
        return count;    
    }    
    public double getAverageLength(Shape s) {
        // Put code here        
        double perimeter = getPerimeter(s);        
        int numSides = getNumPoints(s);        
        double avgLength = perimeter / (double) numSides;                
        return avgLength;    
    }    
    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0;
        
        Point prevPt = s.getLastPoint();        
        // For each point currPt in the shape,       
        for (Point currPt : s.getPoints()) {            
            // Find distance from prevPt point to currPt             
            double currDist = prevPt.distance(currPt);
            
            if(currDist > largestSide){
                largestSide = currDist;
            }
            // Update prevPt to be currPt            
            prevPt = currPt;        
        }
        
        return largestSide;   
    }    
    public double getLargestX(Shape s) {        
        // Put code here
        double largestX = 0;

        for(Point pt : s.getPoints()){
            if(pt.getX() > largestX){
                largestX = pt.getX();
            }
        }
        
        return largestX;
    }    
    public double getLargestPerimeterMultipleFiles() {        
        // Put code here
        double largestPerim = 0, currPerim;
        DirectoryResource dr = new DirectoryResource();

        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            currPerim = getPerimeter(s);
            if(currPerim > largestPerim){
                largestPerim = currPerim;
            }
        }

        return largestPerim;
    }    
    public String getFileWithLargestPerimeter() {        
        // Put code here        
        File temp = null;
        double largestPerim = 0;
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            
            if(currPerim > largestPerim){
                largestPerim = currPerim;
                temp = f;
            }
        }

        // replace this code        
        return temp.getName();    
    }    
    public void testPerimeter () {        
        FileResource fr = new FileResource();        
        Shape s = new Shape(fr);        
        double length = getPerimeter(s);        
        int numPts = getNumPoints(s);        
        double avgLen = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("Number of Points in Shape = " + numPts);        
        System.out.println("Perimeter = " + length);        
        System.out.println("Average Line Length = " + avgLen);
        System.out.println("Largest Side Length = " + largestSide);
        System.out.println("Largest X-Value = " + largestX);
    }        
    public void testPerimeterMultipleFiles() {        
        // Put code here
        double largestPerim = getLargestPerimeterMultipleFiles();

        System.out.println("Largest Perimeter of selected files = " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {        
        // Put code here
        String string = new String();
        string = getFileWithLargestPerimeter();
        System.out.println("FileName of Largest Perimeter = " + string);
    }    
    // This method creates a triangle that you can use to test your other methods    
    public void triangle(){        
        Shape triangle = new Shape();        
        triangle.addPoint(new Point(0,0));        
        triangle.addPoint(new Point(6,0));        
        triangle.addPoint(new Point(3,6));        
        for (Point p : triangle.getPoints()){            
            System.out.println(p);        
        }        
        double peri = getPerimeter(triangle);        
        System.out.println("perimeter = "+peri);    
    }    
    // This method prints names of all files in a chosen folder that you can use to test your other methods    
    public void printFileNames() {        
        DirectoryResource dr = new DirectoryResource();        
        for (File f : dr.selectedFiles()) {            
            System.out.println(f);        
        }    
    }    
    public static void main (String[] args) {        
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();        
//        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}