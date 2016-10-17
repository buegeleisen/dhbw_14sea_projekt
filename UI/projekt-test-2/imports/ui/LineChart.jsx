import React, {Component, PropTypes} from 'react';
import {Line} from 'react-chartjs-2';


export default class LineChart extends Component{
    render() {
         const data = {
            datasets: [{
            label: this.props.labelName,
            data: this.props.lineChartData,
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
            <div className="col-md-12 container">
                <Line ref='data' data = {data} options={options}/>
            </div>
            );
        }
};

LineChart.propTypes = {
  lineChartData: PropTypes.array,
  labelName: PropTypes.string
};
