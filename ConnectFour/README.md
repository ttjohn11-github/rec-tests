Connect4Game REST APIS
====================================================
@see Java class Connect4Service <br>
1) PUT /Connect4 , create game  .no params or request body<br>
2) GET /Connect4/{gameId}, get all slots in a given game of "gameId"<br>
3) GET /Connect4/{gameId}/columns , gets all columns that player can play now<br>
4) POST /Connect4/{gameId}, RequestBody Move object specifying colour and column of move. it returns outcome of a move:- win/draw/incomplete<br>
<br>
/**/<br>
Following not implemented ...<br>
a) logic for finding the WIN veritically and diagonally<br>
b) persistence/keep in memory of the games<br>
c) failed unit tests are ignored, since the logic is not implemented yet<br>
d) security - i.e. if a user send wrong id of game, is not handled in this. should be associated with user session or so.<br>


