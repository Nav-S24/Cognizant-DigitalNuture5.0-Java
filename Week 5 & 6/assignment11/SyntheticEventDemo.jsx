import React, { useState } from 'react';

const SyntheticEventDemo = () => {
  const [message, setMessage] = useState('');

  // React wraps native DOM events in a SyntheticEvent (e) for cross-browser consistency
  const onPress = (e) => {
    setMessage('I was clicked');
    console.log('Synthetic event type:', e.type);
  };

  return (
    <div>
      <button onClick={onPress}>Click on me</button>
      <p>{message}</p>
    </div>
  );
};

export default SyntheticEventDemo;
