import React from 'react';

const players = [
  { name: 'Rohit Sharma', score: 85 },
  { name: 'Virat Kohli', score: 92 },
  { name: 'KL Rahul', score: 45 },
  { name: 'Shubman Gill', score: 68 },
  { name: 'Rishabh Pant', score: 55 },
  { name: 'Hardik Pandya', score: 74 },
  { name: 'Ravindra Jadeja', score: 40 },
  { name: 'Axar Patel', score: 30 },
  { name: 'Jasprit Bumrah', score: 20 },
  { name: 'Mohammed Shami', score: 15 },
  { name: 'Kuldeep Yadav', score: 10 },
];

const ListofPlayers = () => {
  // ES6 arrow function used to filter players with scores below 70
  const playersBelow70 = players.filter((player) => player.score < 70);

  return (
    <div>
      <h2>List of Players (map)</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>

      <h2>Players With Score Below 70</h2>
      <ul>
        {playersBelow70.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
