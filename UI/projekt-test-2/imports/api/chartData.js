import { Mongo } from 'meteor/mongo';

export const MillingTemperatureData = new Mongo.Collection('millingtemperaturedata');
export const MillingSpeedData = new Mongo.Collection('millingspeeddata');
export const DrillingTemperatureData = new Mongo.Collection('drillingtemperaturedata');
export const DrillingSpeedData = new Mongo.Collection('drillingspeeddata');
