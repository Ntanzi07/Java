package Stacks;

public class Pilha {
    
    private No refNoEntradaPilha;

    public Pilha() {
        refNoEntradaPilha = null;
    }

    public void push(No novoNo){
        No refAuxuliar = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAuxuliar);
    }

    public No pop(){
        if(!this.isEmpty()){
            No noPoped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            return noPoped;
        }
        return null;
    }

    public No top(){
        return refNoEntradaPilha;
    }

    public boolean isEmpty(){
        return refNoEntradaPilha == null ? true : false;
    }   

    @Override
    public String toString() {
        String  stringRetorno;
        stringRetorno = 
              "---------------------\n"
            + "        Pilha\n"
            + "---------------------\n";

        No noAuxiliar = refNoEntradaPilha;

        while (true) {
            if(noAuxiliar != null){
                stringRetorno += "[No{dado=" + noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getRefNo();
            }else{
                break;
            }
        }
        stringRetorno += "=====================\n";
        return stringRetorno;
    }

    
}
