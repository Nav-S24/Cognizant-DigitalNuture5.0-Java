import React from 'react';

const IndianPlayers = () => {
  // 2.a — Destructuring to pick out Odd Team / Even Team players
  const oddTeamPlayers = ['Rohit Sharma', 'Virat Kohli', 'KL Rahul', 'Rishabh Pant', 'Ravindra Jadeja'];
  const evenTeamPlayers = ['Shubman Gill', 'Hardik Pandya', 'Axar Patel', 'Jasprit Bumrah', 'Mohammed Shami'];

  const [oddPlayer1, oddPlayer2, oddPlayer3, ...restOddPlayers] = oddTeamPlayers;
  const [evenPlayer1, evenPlayer2, evenPlayer3, ...restEvenPlayers] = evenTeamPlayers;

  // 2.b — Merge T20players and RanjiTrophy players using spread (ES6 merge feature)
  const T20players = ['Rohit Sharma', 'Virat Kohli', 'Suryakumar Yadav'];
  const RanjiTrophyPlayers = ['Sarfaraz Khan', 'Prithvi Shaw', 'Yashasvi Jaiswal'];
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players</h2>
      <p>
        {oddPlayer1}, {oddPlayer2}, {oddPlayer3}, {restOddPlayers.join(', ')}
      </p>

      <h2>Even Team Players</h2>
      <p>
        {evenPlayer1}, {evenPlayer2}, {evenPlayer3}, {restEvenPlayers.join(', ')}
      </p>

      <h2>Merged Players (T20 + Ranji Trophy)</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
