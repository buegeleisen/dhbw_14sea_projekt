import React, {Component, PropTypes} from 'react';
import {Line} from 'react-chartjs-2';
import { LineChartData } from '../api/chartData.js';
import { createContainer } from 'meteor/react-meteor-data';


class LineChartNew extends Component{
    render() {


         const data = {
            datasets: [{
            label: 'Temperature',
            data: this.props.linechartdata,
            fill: false,
            lineTension: 0.1,
            backgroundColor: "rgba(75,192,192,0.4)",
            borderColor: "rgba(75,192,192,1)",
            borderCapStyle: 'butt',
            borderDash: [],
            borderDashOffset: 0.0,
            borderJoinStyle: 'miter',
            pointBorderColor: "rgba(75,192,192,1)",
            pointBackgroundColor: "#fff",
            pointBorderWidth: 1,
            pointHoverRadius: 5,
            pointHoverBackgroundColor: "rgba(75,192,192,1)",
            pointHoverBorderColor: "rgba(220,220,220,1)",
            pointHoverBorderWidth: 2,
            pointRadius: 1,
            pointHitRadius: 10,
            spanGaps: false,
        }]
    };



   const options = {
        scales: {
            xAxes: [{
                type: 'linear',
                position: 'bottom',
                ticks:{
                    maxTicksLimit: 11,
                    stepSize: 1
                }
            }]
        }
    };


        return (
            <div className="container">
                <Line ref='data' data = {data} options={options}/>
            </div>
            );
        }
};

LineChartNew.propTypes = {
  linechartdata: PropTypes.array.isRequired,

};

export default createContainer(() => {
  return {
    linechartdata: LineChartData.find({}, {sort:{_id:-1},limit: 5} ).fetch(),
  };
}, LineChartNew);
