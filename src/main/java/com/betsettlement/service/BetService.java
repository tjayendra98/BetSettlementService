package com.betsettlement.service;

import com.betsettlement.entity.Bet;

import java.util.List;

public interface BetService {
     void saveBet(Bet bet);

     void saveMultipleBets(List<Bet> bets);

     List<Bet> getBetsByEventId(String eventId);

     List<Bet> getAllBets();
}
