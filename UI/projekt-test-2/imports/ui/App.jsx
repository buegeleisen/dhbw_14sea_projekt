import React, { Component } from 'react';
import {LineChart} from 'react-easy-chart';

// App component - represents the whole app

export default React.createClass({
   mouseOverHandler(d, e) {
    this.setState({
      showToolTip: true,
      top: e.y,
      left: e.x,
      value: d.value,
      key: d.data.key});
  }

  mouseMoveHandler(e) {
    if (this.state.showToolTip) {
      this.setState({top: e.y, left: e.x});
    }
  }

  mouseOutHandler() {
      this.setState({showToolTip: false});
    }

    createTooltip() {
    if (this.state.showToolTip) {
      return (
        <ToolTip
          top={this.state.top}
          left={this.state.left}
        >
          The value of {this.state.key} is {this.state.value}
        </ToolTip>
      );
    }
    return false;
  }


    render() {
        return (
            <div className="container">
                <header>
                <h1>Dashboard</h1>
                </header>
                <LineChart
                  xType={'time'}
                axes
                dataPoints
                grid
                verticalGrid
                mouseOverHandler={this.mouseOverHandler}
                mouseOutHandler={this.mouseOutHandler}
                mouseMoveHandler={this.mouseMoveHandler}
                interpolate={'cardinal'}
                width={700}
                height={250}
                data={[
                  [
                    { x: '1-Jan-15', y: 20 },
                    { x: '1-Feb-15', y: 10 },
                    { x: '1-Mar-15', y: 33 },
                    { x: '1-Apr-15', y: 45 },
                    { x: '1-May-15', y: 15 }
                  ], [
                    { x: '1-Jan-15', y: 10 },
                    { x: '1-Feb-15', y: 15 },
                    { x: '1-Mar-15', y: 13 },
                    { x: '1-Apr-15', y: 15 },
                    { x: '1-May-15', y: 10 }
                  ]
                ]}
    />
            </div>
            );
        }
});
