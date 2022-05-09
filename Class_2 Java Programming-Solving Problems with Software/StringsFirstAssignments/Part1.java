
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public static String findSimpleGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf("TAA");
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
        String s1 = "ACTGATAGCTAGTTAATGCCAAATTCGTAA";   //No ATG
        String s2 = "ACTGATATGCTAGTTATGCCAAATTCGGAA";   //No TAA
        String s3 = "ACTGATAGCTAGTTCATGCCAAATTCGTGA";   //No ATG or TAA
        String s4 = "ACTGATGCAGCTAGTCTAATGCAATCGTAA";   //ATG and TAA Present and multiple of 3
        String s5 = "ACTGATATGCTAGTTAATGCCAATTCGTAA";   //ATG and TAA Present but not multiple of 3

        System.out.println(s1);
        String gene1 = findSimpleGene(s1);
        System.out.println(gene1);

        System.out.println(s2);
        String gene2 = findSimpleGene(s2);
        System.out.println(gene2);

        System.out.println(s3);
        String gene3 = findSimpleGene(s3);
        System.out.println(gene3);

        System.out.println(s4);
        String gene4 = findSimpleGene(s4);
        System.out.println(gene4);

        System.out.println(s5);
        String gene5 = findSimpleGene(s5);
        System.out.println(gene5);
    }
}
