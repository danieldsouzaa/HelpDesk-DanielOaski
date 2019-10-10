package es.senac.br.helpdesk_danieloaski.model;

public enum Status {
    //ENUN CLASSE PADRÃO REESCREVER METODO TOSTRING

    ABERTO{
        @Override
        public String toString(){
            return "ABERTO";
        }

    },

    FECHADO{
        @Override
        public String toString(){
            return "FECHADO";
        }

    }
}
