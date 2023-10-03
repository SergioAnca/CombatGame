package characters;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class CharacterCreation {
                
        public static List<Character> CharacterList;
        
        public record Character(Integer id, String Name, String Description, Integer Attack, Integer Defense, Integer Iq, 
                Integer Resistence,Integer Health_Points) {
                    
                /**************************************/
                /***CHARACTER CREATION FROM CSV DATA***/
                /**************************************/
        
                public static int cont;
                public static Character create(String s/*Integer id, String Name, String Description, Integer Health_Points, 
                Integer Attack, Integer Defense, Integer Iq*/){
                    String[] v = s.split(";");
                    String Name = v[0];
                    String Description = v[1];
                    Integer Attack = Integer.valueOf(v[2].trim());
                    Integer Defense = Integer.valueOf(v[3].trim());
                    Integer Iq = Integer.valueOf(v[4].trim());
                    Integer Resistence = Integer.valueOf(v[5].trim()); 
                    Integer Health_Points = Integer.valueOf(v[6].trim()); 
                    return new Character(cont++, Name, Description, Attack, Defense, Iq, Resistence, Health_Points);
                }
                @Override
                public String toString() {
                    return String.format("Name: "+Name+" Description: "+Description+"\n");
                }

                /******************************/
                /***CHARACTER INITIALIZATION***/
                /******************************/
                
                public static void iniData(String file) {
                        Character.cont = 0; 
                        CharacterList = streamFromFile(file).filter(linea->!String.valueOf(linea.charAt(0)).equals("^"))
                                        .map(Character::create).toList();
                }

                    //AUXILIAR METHOD TO CONVERT CSV LINES INTO A STREAM
                    public static Stream<String> streamFromFile(String file) {
                        Stream<String> r = null;
                        try {
                            r = Files.lines(Paths.get(file), Charset.defaultCharset());
                        } catch (IOException e) {
                            throw new IllegalArgumentException("No se ha encontrado el fichero " + file);
                        }
                        return r;
                    }
        }
      
        

}
