import React from 'react';

// Function that takes "welcome" as an argument
const sayWelcome = (message) => {
  alert(message);
};

const WelcomeButton = () => {
  return (
    <div>
      <button onClick={() => sayWelcome('welcome')}>Say Welcome</button>
    </div>
  );
};

export default WelcomeButton;
