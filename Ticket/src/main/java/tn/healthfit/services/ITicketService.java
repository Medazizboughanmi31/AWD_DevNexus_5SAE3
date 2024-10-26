package tn.healthfit.services;

import tn.healthfit.entities.Ticket;

import java.util.List;

public interface ITicketService {
    public List<Ticket> retrieveAllTickets() ;
    public Ticket retrieveTicket(int idTicket) ;
    public Ticket addTicket(Ticket ticket) ;
    public void removeTicket(int idTicket) ;
    public Ticket modifyTicket(Ticket ticket) ;
}
