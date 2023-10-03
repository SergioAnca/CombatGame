package auxiliar;

public class MultipleInt {
    
    public record IntQuartet(Integer f, Integer s, Integer t, Integer fo) {
        public static IntQuartet of(Integer f, Integer s, Integer t, Integer fo) {
            return new IntQuartet(f, s, t, fo);
        }    
    }
    
    public record IntTrio(Integer f, Integer s, Integer t) {
        public static IntTrio of(Integer f, Integer s, Integer t) {
            return new IntTrio(f, s, t);
        }    
    }
}
