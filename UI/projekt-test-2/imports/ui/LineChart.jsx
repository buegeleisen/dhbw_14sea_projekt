import React, {Component, PropTypes} from 'react';
import {Line} from 'react-chartjs-2';


export default class LineChart extends Component{
    render() {
         const data = {
            labels: this.props.xAxis,
            datasets: [{
            label: this.props.labelName,
            data: this.props.yAxis,
            fill: false,
            lineTension: 0.3,
            backgroundColor: this.props.backgroundColor,
            borderColor: this.props.borderColor,
            borderCapStyle: 'butt',
            borderDash: [],
            borderDashOffset: 0.0,
            borderJoinStyle: 'miter',
            pointBorderColor: this.props.pointBorderColor,
            pointBackgroundColor: "#fff",
            pointBorderWidth: 4,
            pointHoverRadius: 5,
            pointHoverBackgroundColor: this.props.pointHoverBackgroundColor,
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
  backgroundColor : PropTypes.string,
  borderColor: PropTypes.string,
  pointHoverBackgroundColor: PropTypes.string,
  yAxis: PropTypes.array,
  xAxis: PropTypes.array,
  labelName: PropTypes.string
};
