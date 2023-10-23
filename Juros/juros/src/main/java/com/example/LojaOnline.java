public class LojaOnline {
    public NotaFiscal efetuarCompra(Compra compra) {

        double total = this.calcularTotal(compra);
        int codigo = this.gerarCodNota();

        NotaFiscal nf = new NotaFiscal();
        nf.setItem(compra.getCarrinho());
        nf.setCodNota(codigo);
        nf.setValorParcela(calcularParcela(total, codigo));
        nf.setTotal(total);
        

        return nf;

    }

    private double calcularTotal(Compra compra) {

        double total = 0;

        for (Item item : compra.getCarrinho()) {
            total += item.getPreco();
        }

        // ****** CALCULO DESCONTO (FORMA DE PAGAMENTO) ******

        String formPag1 = "DÉBITO";
        String formPag2 = "PIX";
        // String formPag3 = "CRÉDITO";
        double desconto = 0;

        if (compra.getFormaPag().equals(formPag1)) {
            desconto = 0.05 * total;
        } else if (compra.getFormaPag().equals(formPag2)) {
            desconto = 0.10 * total;
        } else {
            desconto = 0;
        }

        // ****** CALCULO DE JUROS ******
        double juros = 0;
        if (compra.getParcelas() > 0) {
            juros = 0.03 * total * compra.getParcelas();
        }else{
            juros = 0;
        }
    

        // ****** CALCULO DE VALOR FINAL ******
        
        total = total - desconto + juros;

        return total;
    }

    private double verificarCupom(String cupom) {
        double cupomUtilizado = 0;

        String cupom1 = "QUERO100";
        String cupom2 = "QUERO200";
        String cupom3 = "QUERO500";

        if (cupom.equals(cupom1)) {
            cupomUtilizado = 100;
        } else if (cupom.equals(cupom2)) {
            cupomUtilizado = 200;
        } else if (cupom.equals(cupom3)) {
            cupomUtilizado = 500;
        } else {
            cupomUtilizado = 0;
            System.out.println("Esse cupom não existe");
        }

        return cupomUtilizado;

    }

    private double calcularParcela(double total, int parcelas) {

        return total / parcelas;

    }

    private int gerarCodNota() {
        int codigo = (int) (Math.random() * 999);
        return codigo;
    }
}

/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * double calcularTotal = desconto - (valorF.getTotal() * Math.pow(1 + (juros /
 * 100), compra.getParcelas()));
 */