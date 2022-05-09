
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public static String findSimpleGene(String dna, String startCodon, String stopCodon){
        if(dna.compareTo(dna.toUpperCase()) == 0){
            dna = dna.toUpperCase();
            startCodon = startCodon.toUpperCase();
            stopCodon = stopCodon.toUpperCase();
        }else if (dna.compareTo(dna.toLowerCase()) == 0) {
            dna = dna.toLowerCase();
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        int startIndex = dna.indexOf(startCodon);
        if(startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon);
        if(stopIndex == -1){
            return "";
        }
        String gene = dna.substring(startIndex, stopIndex + 3);
        if ((gene.length() % 3) == 0){
            return gene;
        }else{
            return "";
        }

    }
    public static void testSimpleGene (){
        //Test findSimpleGene
        String upperStart = "ATG";
        String upperStop = "TAA";
        String lowerStart = "atg";
        String lowerStop = "taa";
        String s1 = "ACTGATAGCTAGTTAATGCCAAATTCGTAA";   //No ATG
        String s2 = "ACTGATATGCTAGTTATGCCAAATTCGGAA";   //No TAA
        String s3 = "ACTGATAGCTAGTTCATGCCAAATTCGTGA";   //No ATG or TAA
        String s4 = "ACTGATGCAGCTAGTCTAATGCAATCGTAA";   //ATG and TAA Present and multiple of 3
        String s5 = "ACTGATATGCTAGTTAATGCCAATTCGTAA";   //ATG and TAA Present but not multiple of 3

        String lowerS1 = "actgatagctagttaatgccaaattcgtaa";   //No ATG
        String lowerS2 = "actgatatgctagttatgccaaattcggaa";   //No TAA
        String lowerS3 = "actgatagctagttcatgccaaattcgtga";   //No ATG or TAA
        String lowerS4 = "actgatgcagctagtctaatgcaatcgtaa";   //ATG and TAA Present and multiple of 3
        String lowerS5 = "actgatatgctagttaatgccaattcgtaa";   //ATG and TAA Present but not multiple of 3

        System.out.println(s1);
        String gene1 = findSimpleGene(s1, upperStart, upperStop);
        System.out.println(gene1);

//        System.out.println(lowerS1);
//        String gene1 = findSimpleGene(lowerS1, lowerStart, lowerStop);
//        System.out.println(gene1);

        System.out.println(s2);
        String gene2 = findSimpleGene(s2, upperStart, upperStop);
        System.out.println(gene2);

//        System.out.println(lowerS2);
//        String gene2 = findSimpleGene(lowerS2, lowerStart, lowerStop);
//        System.out.println(gene2);

        System.out.println(s3);
        String gene3 = findSimpleGene(s3, upperStart, upperStop);
        System.out.println(gene3);

//        System.out.println(lowerS3);
//        String gene3 = findSimpleGene(lowerS3, lowerStart, lowerStop);
//        System.out.println(gene3);

//        System.out.println(s4);
//        String gene4 = findSimpleGene(s4, upperStart, upperStop);
//        System.out.println(gene4);

        System.out.println(lowerS4);
        String gene4 = findSimpleGene(lowerS4, lowerStart, lowerStop);
        System.out.println(gene4);

        System.out.println(s5);
        String gene5 = findSimpleGene(s5, upperStart, upperStop);
        System.out.println(gene5);

//        System.out.println(lowerS5);
//        String gene5 = findSimpleGene(lowerS5, lowerStart, lowerStop);
//        System.out.println(gene5);
    }
}
