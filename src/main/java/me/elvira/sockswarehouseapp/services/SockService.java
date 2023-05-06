package me.elvira.sockswarehouseapp.services;

import me.elvira.sockswarehouseapp.model.Color;
import me.elvira.sockswarehouseapp.model.Size;
import me.elvira.sockswarehouseapp.model.Sock;
import me.elvira.sockswarehouseapp.model.SockDto;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class SockService {
    private final Map<Sock, Integer> socks = new HashMap<>();

    public void addSock(SockDto sockDto){
        validateRequest(sockDto);
        Sock sock = mapToSock(sockDto);
        if (socks.containsKey(sock)) {
            socks.put(sock, socks.get(sock) + sockDto.getQuantity());
        } else {
            socks.put(sock, sockDto.getQuantity());
        }
//        auditService.recordAddOperation(sock, sockDto.getQuantity());
    }

    public void issuanceSock(SockDto sockDto){
        decreaseSockQuantity(sockDto, true);
    }

    public void defectedSock(SockDto sockDto){
        decreaseSockQuantity(sockDto, false);
    }

    private void decreaseSockQuantity(SockDto sockDto, boolean isIssue) {
        validateRequest(sockDto);
        Sock sock = mapToSock(sockDto);
        int sockQuantity = socks.getOrDefault(sock, 0); //
        if (sockQuantity <= sockDto.getQuantity()){
            socks.put(sock, sockQuantity - sockDto.getQuantity());
        } else {
            throw new IllegalArgumentException("There is not socks or not enough socks");
        }
//        if (isIssue){
//            auditService.recordIssuanceOperation(sock, sockDto.getQuantity());
//        } else {
//            auditService.recordDefectedOperation(sock, sockDto.getQuantity());
//        }
    }

    public int getSockQuantity(Size size, Color color, Integer cottonMin, Integer cottonMax){
        int total = 0;
        for (Map.Entry<Sock, Integer> entry : socks.entrySet()){
            if (size != null && !entry.getKey().getSize().equals(size)){
                continue;
            }
            if (color != null && !entry.getKey().getColor().equals(color)){
                continue;
            }

            if (cottonMin != null && entry.getKey().getCottonPercentage() < cottonMin){
                continue;
            }
            if (cottonMax != null && entry.getKey().getCottonPercentage() > cottonMax){
                continue;
            }
            total += entry.getValue();
        }
        return total;
    }

    private void validateRequest(SockDto sockDto){
        if (sockDto.getColor() == null || sockDto.getSize() == null){
            throw new IllegalArgumentException("All fields should be filled");
        }
        if (sockDto.getCottonPercentage() < 0 || sockDto.getCottonPercentage() > 100){
            throw new IllegalArgumentException("Cotton percent should be > 0 and < 100");
        }
        if (sockDto.getQuantity() <= 0){
            throw new IllegalArgumentException("Quantity should be more than 0");
        }
    }

    private Sock mapToSock(SockDto sockDto){
        return new Sock(sockDto.getSize(),
                sockDto.getColor(),
                sockDto.getQuantity());
    }

    private SockDto mapToDTO(Sock sock, int quantity){
        SockDto sockDto = new SockDto();
        sockDto.setSize(sock.getSize());
        sockDto.setColor(sock.getColor());
        sockDto.setCottonPercentage(sock.getCottonPercentage());
        sockDto.setQuantity(quantity);
        return sockDto;
    }

}
