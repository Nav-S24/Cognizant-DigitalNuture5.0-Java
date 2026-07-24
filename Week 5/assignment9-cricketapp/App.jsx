import React from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';

const App = () => {
  // Toggle this flag to switch which component is displayed on the home page
  const flag = true;

  let content;
  if (flag) {
    content = <ListofPlayers />;
  } else {
    content = <IndianPlayers />;
  }

  return (
    <div>
      <h1>Cricket App</h1>
      {content}
    </div>
  );
};

export default App;
