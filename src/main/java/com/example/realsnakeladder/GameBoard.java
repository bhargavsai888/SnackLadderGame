package com.example.realsnakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class GameBoard {
    static int tileSize=40;
    static int height=10;
    static int width=10;
    static ArrayList<Pair<Integer,Integer>>positioncCoordinates;
static ArrayList<Integer>snakeLadderPosition;

    public GameBoard(){
        populatepositioncCoordinates();
        setPositionCoordinates();
    }
  public int getXValue(int piecePosition){
    return positioncCoordinates.get(piecePosition).getKey();
}


    public int getYValue(int piecePosition){

        return positioncCoordinates.get(piecePosition).getValue();
    }
    public int playerPositionAtSnackOrLadder(int piecePosition){
        if(piecePosition!=snakeLadderPosition.get(piecePosition)){
            return snakeLadderPosition.get(piecePosition);
        }
        return -1;
    }

private void setPositionCoordinates(){
        snakeLadderPosition=new ArrayList<>();
    for (int i = 0; i<101  ; i++) {
        snakeLadderPosition.add(i);
    }
    snakeLadderPosition.set(2,23);
    snakeLadderPosition.set(6,45);
    snakeLadderPosition.set(20,59);
    snakeLadderPosition.set(43,17);
    snakeLadderPosition.set(50,5);
    snakeLadderPosition.set(52,72);
    snakeLadderPosition.set(56,8);
    snakeLadderPosition.set(57,96);
    snakeLadderPosition.set(71,92);
    snakeLadderPosition.set(73,15);
    snakeLadderPosition.set(84,58);
    snakeLadderPosition.set(87,49);
    snakeLadderPosition.set(98,40);


}
    private static void populatepositioncCoordinates(){
        positioncCoordinates=new ArrayList<Pair<Integer, Integer>>();
        positioncCoordinates.add(new Pair<Integer,Integer>(20,380));

        int xTilePos,ytilePos;
        for (int i = height-1; i >=0 ; i--) {
            for (int j = width-1; j >=0 ; j--) {
               if(i%2!=0){
                   xTilePos=tileSize*width-(tileSize/2 + j*tileSize);
               }
               else{
                   xTilePos=tileSize/2 + j*tileSize;
               }
               ytilePos=tileSize/2 + i*tileSize;
               positioncCoordinates.add(new Pair<Integer,Integer>(xTilePos,ytilePos));
            }
        }
        for (int i = 0; i < positioncCoordinates.size(); i++) {
            System.out.println(i + "x:"+positioncCoordinates.get(i).getKey()+  "y:" + positioncCoordinates.get(i).getKey());

        }

    }


}
