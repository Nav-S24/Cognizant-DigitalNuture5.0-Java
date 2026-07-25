import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = { amount: '', currency: '', euro: null };

    this.handleAmountChange = this.handleAmountChange.bind(this);
    this.handleCurrencyChange = this.handleCurrencyChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleAmountChange(event) {
    this.setState({ amount: event.target.value });
  }

  handleCurrencyChange(event) {
    this.setState({ currency: event.target.value });
  }

  // Handles the Convert button click and converts Rupees to Euro
  handleSubmit(event) {
    event.preventDefault();
    const conversionRate = 0.011; // approx INR -> EUR
    const euroValue = (Number(this.state.amount) * conversionRate).toFixed(2);
    this.setState({ euro: euroValue });
  }

  render() {
    return (
      <div>
        <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Amount: </label>
            <input type="number" value={this.state.amount} onChange={this.handleAmountChange} />
          </div>
          <div>
            <label>Currency: </label>
            <input type="text" value={this.state.currency} onChange={this.handleCurrencyChange} />
          </div>
          <button type="submit">Submit</button>
        </form>
        {this.state.euro !== null && <p>Converted amount: €{this.state.euro}</p>}
      </div>
    );
  }
}

export default CurrencyConvertor;
