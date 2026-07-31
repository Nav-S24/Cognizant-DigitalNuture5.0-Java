import React from 'react';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore
        name="John Doe"
        school="Greenwood High School"
        total={430}
        subjects={5}
        goal={80}
      />
    </div>
  );
}

export default App;
