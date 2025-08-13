package com.betsettlement.controller;

import com.betsettlement.dto.EventOutcome;
import com.betsettlement.entity.Bet;
import com.betsettlement.service.BetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BetController {

    private final BetService betService;

    @PostMapping("/bet")
    public ResponseEntity<String> saveBet(@RequestBody Bet bet) {
        log.info("Save bet: {}", bet);
        if(ObjectUtils.isEmpty(bet)) {
            return ResponseEntity.badRequest().body("Bet should not be empty.");
        }
        betService.saveBet(bet);
        return ResponseEntity.ok().body("Bet saved");
    }

    @PostMapping("/bets")
    public ResponseEntity<String> saveBets(@RequestBody List<Bet> bets) {
        log.info("Save bets: {}", bets);
        betService.saveMultipleBets(bets);
        return ResponseEntity.ok().body("Bet saved");
    }

    @GetMapping("/bets")
    public ResponseEntity<List<Bet>> getAllBets() {
        log.info("Get all bets");
        List<Bet> bets = betService.getAllBets();
        return ResponseEntity.ok().body(bets);
    }


}
