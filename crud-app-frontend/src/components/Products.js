import React, { Component } from "react";
import ProductService from "../app/ProductService";
import { faEdit, faSearch, faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

class Products extends Component {
  constructor(props) {
    super(props);

    this.state = {
      products: [],
      query: "",
    };

    this.changeQueryHandler = this.changeQueryHandler.bind(this);
    this.editProduct = this.editProduct.bind(this);
    this.deleteProduct = this.deleteProduct.bind(this);
  }

  componentDidMount() {
    this.handleGetProducts();
  }

  handleGetProducts() {
    ProductService.getProducts().then((res) => {
      this.setState({ products: res.data });
    });
  }

  deleteProduct(id) {
    ProductService.deleteProduct(id).then((res) => {
      this.setState({
        products: this.state.products.filter((product) => product.id !== id),
      });
    });
  }

  editProduct(id) {
    this.props.history.push(`/NewProduct/${id}`);
  }

  changeQueryHandler = (event) => {
    this.setState({ query: event.target.value });
  };

  handleSearch = (event) => {
    event.preventDefault(); // Prevents the form from submitting in the default way

    if (this.state.query.trim() !== "") {
      ProductService.getProduct(this.state.query).then((res) => {
        this.setState({ products: res.data });
      });
    } else {
      this.handleGetProducts();
    }
  };

  render() {
    return (
      <div className="row">
        <div className="col-md-6">
          <div className="card m-1">
            <div className="card-body">
              <form onSubmit={this.handleSearch}>
                <div className="row g-2">
                  <div className="col-auto">
                    <input
                      name="query"
                      value={this.state.query}
                      onChange={this.changeQueryHandler}
                      className="form-control"
                    />
                  </div>
                  <div className="col-auto">
                    <button className="btn btn-success">
                      <FontAwesomeIcon icon={faSearch} />
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
          <div className="card m-1">
            <div className="card-body">
              <table className="table table-striped table-bordered">
                <thead>
                  <tr>
                    <th> ID</th>
                    <th> Nom</th>
                    <th> Prix Unitaire</th>
                    <th> Quantité </th>
                    <th> Actions</th>
                  </tr>
                </thead>
                <tbody>
                  {this.state.products.map((product) => (
                    <tr key={product.id}>
                      <td>{product.id}</td>
                      <td> {product.nom} </td>
                      <td> {product.prixUnitaire}</td>
                      <td> {product.quantite}</td>
                      <td>
                        <button
                          onClick={() => this.deleteProduct(product.id)}
                          className="btn btn-online"
                        >
                          <FontAwesomeIcon icon={faTrash}></FontAwesomeIcon>
                        </button>
                        <button
                          onClick={() => this.editProduct(product.id)}
                          className="btn btn-info"
                        >
                          <FontAwesomeIcon icon={faEdit}></FontAwesomeIcon>
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default Products;
