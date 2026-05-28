package Filas;

public class Fila<T> {
    
    private No<T> refNoentradaFila;

    public Fila(){
        this.refNoentradaFila = null;
    }

    public void enqueue(T obj){
        No<T> novoNo = new No<T>(obj);
        novoNo.setRefNo(refNoentradaFila);
        refNoentradaFila = novoNo;
    }

    @SuppressWarnings("unchecked")
    public T first(){
        if(!this.isEmpty()){
            No<T> primeiroNo = refNoentradaFila;
            while (primeiroNo.getRefNo() != null) {
                primeiroNo = primeiroNo.getRefNo();
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public T dequeue(){
        if(!this.isEmpty()){
            No<T> primeiroNo = refNoentradaFila;
            No<T> noAuxiliar = refNoentradaFila;
            while (primeiroNo.getRefNo() != null) {
                noAuxiliar = primeiroNo;
                primeiroNo = primeiroNo.getRefNo();
            }
            noAuxiliar.setRefNo(null);
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoentradaFila == null ? true : false;
    }

    @Override
    public String toString(){
        String stringRetorno =
             "--------------------\n"
            +"        Fila\n"
            +"--------------------\n";
        
        if (!this.isEmpty()) {
            No<T> noAuxiliar = refNoentradaFila;
            while (true){
                stringRetorno += noAuxiliar + "---->";
                if(noAuxiliar.getRefNo() != null){
                    noAuxiliar = noAuxiliar.getRefNo();
                }else{
                    stringRetorno += "null";
                    break;
                }
            }
        }else{
            stringRetorno += "null";
        }

        return stringRetorno;
    }
}
