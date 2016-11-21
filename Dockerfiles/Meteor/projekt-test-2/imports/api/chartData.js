import { Mongo } from 'meteor/mongo';

export const MillingHeatData = new Mongo.Collection('millingheatdata');
export const MillingSpeedData = new Mongo.Collection('millingspeeddata');
export const DrillingHeatData = new Mongo.Collection('drillingheatdata');
export const DrillingSpeedData = new Mongo.Collection('drillingspeeddata');
