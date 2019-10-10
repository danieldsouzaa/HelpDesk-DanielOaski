package es.senac.br.helpdesk_danieloaski.api;

public interface OnEventListener<T> {
    public void onSuccess(T object);
    public void onFailure(Exception e);
}