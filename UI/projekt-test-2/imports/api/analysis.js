import {ProductData} from './productData.js';
//Products

export function getAllProducts(){
  return ProductData.find({}).fetch();
}

export function getOneProduct(pid){
  return ProductData.find({id: pid}).fetch();
}

export function getProductsWithFilter( sortNumber, countNumber){
  return ProductData.find({},{sort:{_id: sortNumber}, limit: countNumber}).fetch();
}

export function getAllProductsFromCustomer(cid){
  let i = ProductData.find({"activemq.customernumber": parseInt(cid)}, {sort:{_id:-1}}).fetch();
  return i.map((customerdata) =>(
      customerdata
    ));
}

//Customers
function mapCustomers(){
  return getAllProducts().map((item) => (
     item.activemq.customernumber
  ));
}

export function getAllCustomers(){
  return Array.from(new Set(mapCustomers()));
}

//Analysis

export function getAverageCountProducts(){
  return parseInt((getAllProducts().length / getAllCustomers().length));
}

function add(a, b) {
    return a + b;
}

export function getERPAverageArray(){
  let array = getAllProducts();
  let a1 = array.map((item) =>(item.erpFile.a1)).reduce(add,0);
  let a2 = array.map((item) =>(item.erpFile.a2)).reduce(add,0);
  let b1 = array.map((item) =>(item.erpFile.b1)).reduce(add,0);
  let b2 = array.map((item) =>(item.erpFile.b2)).reduce(add,0);
  let em1 = array.map((item) =>(item.erpFile.em1)).reduce(add,0);
  let em2 = array.map((item) =>(item.erpFile.em2)).reduce(add,0);
  let total = [];
  total.push(parseInt(a1/array.length));
  total.push(parseInt(a2/array.length));
  total.push(parseInt(b1/array.length));
  total.push(parseInt(b2/array.length));
  total.push(parseInt(em1/array.length));
  total.push(parseInt(em2/array.length));
  return total;
}
