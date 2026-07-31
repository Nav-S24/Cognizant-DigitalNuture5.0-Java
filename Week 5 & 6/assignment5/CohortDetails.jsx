import React from 'react';
import styles from './CohortDetails.module.css';

// Sample cohort data — replace with the data already used in your
// downloaded Academy dashboard app (this.props / this.state, etc.)
const cohorts = [
  { id: 1, name: 'React Fundamentals', status: 'ongoing', startDate: '01-Jun-2026', endDate: '30-Jun-2026' },
  { id: 2, name: 'Node.js Bootcamp', status: 'completed', startDate: '01-Apr-2026', endDate: '15-May-2026' },
  { id: 3, name: 'Full Stack Batch', status: 'ongoing', startDate: '10-Jul-2026', endDate: '10-Aug-2026' },
];

const CohortDetails = ({ cohort }) => {
  const titleColor = cohort.status === 'ongoing' ? 'green' : 'blue';

  return (
    <div className={styles.box}>
      <h3 style={{ color: titleColor }}>{cohort.name}</h3>
      <dl>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Start Date</dt>
        <dd>{cohort.startDate}</dd>
        <dt>End Date</dt>
        <dd>{cohort.endDate}</dd>
      </dl>
    </div>
  );
};

// Container that renders one box per cohort — matches "Final Result" screenshot
const CohortDashboard = () => (
  <div>
    {cohorts.map((cohort) => (
      <CohortDetails key={cohort.id} cohort={cohort} />
    ))}
  </div>
);

export default CohortDetails;
export { CohortDashboard };
