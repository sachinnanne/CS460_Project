package com.brianstempin.vindiniumclient.bot.simple;

import com.brianstempin.vindiniumclient.bot.BotMove;
import com.brianstempin.vindiniumclient.dto.GameState;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.StringUtils;

import java.util.StringTokenizer;

public class SachinSimpleBot implements SimpleBot {

    private String[][] boardMap;

    @Override
    public BotMove move(GameState gameState) {
        int boardSize = gameState.getGame().getBoard().getSize();
        String tiles = gameState.getGame().getBoard().getTiles();
        boardMap = parseMap(tiles, boardSize);

        return null;
    }


    private String[][] parseMap(String tileString, int boardSize) {
        String[][] parsedBoard = new String[boardSize][boardSize];

        for(int i = 0 ; i  < boardSize; i++) {
            int rowStart = i * boardSize * 2;
            int rowEnd = rowStart + boardSize * 2;
            String row = tileString.substring(rowStart, rowEnd);
            for(int j = 0 ; j < boardSize; j++) {
                int colStart = j * 2;
                int colEnd = j * 2 + 2;
                parsedBoard[i][j] = row.substring(colStart, colEnd);
            }
        }

        for (String[] strings : parsedBoard) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

        return parsedBoard;

    }

    @Override
    public void setup() {
        //No-Op
    }

    @Override
    public void shutdown() {
        //No-op
    }
}