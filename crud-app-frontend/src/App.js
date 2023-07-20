import React from 'react';

import './App.css';
import Products from './components/Products';
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import NewProduct from './components/NewProduct';
import { Switch } from 'react-router-dom/cjs/react-router-dom.min';

function App() {
  return (
    
    <BrowserRouter>
      <nav className='m-1 p-1 border border-dark'>
        <ul className='nav na-pills'>
          <li>
            <Link className='btn btn-outline-dark ms-1'
              to={"/Products"}>
                Produits
            </Link>
          </li>
          <li>
            <Link className='btn btn-outline-dark ms-1'
              to={"/NewProduct/_add"}>
                Ajouter Produit
            </Link>
          </li>
        </ul>
      </nav>
     <div className='container'>
        <Switch>
        <Route path='/' exact component = {Products} ></Route>
        <Route path='/Products' component = {Products} ></Route>
        <Route path='/NewProduct/:id' component = {NewProduct}></Route>
        </Switch>  
      </div>
    </BrowserRouter>
 
  );
}

export default App;
