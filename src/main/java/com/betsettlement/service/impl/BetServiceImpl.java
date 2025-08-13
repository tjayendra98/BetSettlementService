package com.betsettlement.service.impl;

import com.betsettlement.entity.Bet;
import com.betsettlement.repo.BetRepository;
import com.betsettlement.service.BetService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class BetServiceImpl implements BetService {

    private final BetRepository betRepository;

    @Override
    public void saveBet(Bet bet) {
        betRepository.save(bet);
    }

    @Override
    public void saveMultipleBets(List<Bet> bets) {
        betRepository.saveAll(bets);
    }

    @Override
    public List<Bet> getBetsByEventId(String eventId){
        return betRepository.findByEventId(eventId);
    }

    @Override
    public List<Bet> getAllBets(){
        return betRepository.findAll();
    }

    @PostConstruct
    private void initializeBetData(){

        List<Bet> bets = Stream.of(
                new Bet( 1L,"user1", "cricket1", "market1", "RCB", 100),
                new Bet( 2L,"user2", "cricket1", "market1", "RCB", 200),
                new Bet( 3L,"user3", "cricket1", "market1", "CSK", 150),
                new Bet( 4L,"user4", "cricket1", "market1", "CSK", 150),
                new Bet( 5L,"user5", "cricket1", "market1", "RCB", 250)
                ).toList();
        saveMultipleBets(bets);
        log.info("Bet data initalized.");

    }
}
