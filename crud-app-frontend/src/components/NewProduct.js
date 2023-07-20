import React, { Component } from "react";
import ProductService from "../app/ProductService";

class NewProduct extends Component {
  constructor(props) {
    super(props);

    this.state = {
      id: this.props.match.params.id,
      nom: "",
      prixUnitaire: 0,
      quantite: 0,
    };
    this.changeNomHandler = this.changeNomHandler.bind(this);
    this.changePrixUnitaireHandler = this.changePrixUnitaireHandler.bind(this);
    this.changeQuantiteHandler = this.changeQuantiteHandler.bind(this);
    this.saveOrUpdateProduct = this.saveOrUpdateProduct.bind(this);
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.setState({ id });

    if (this.state.id === "_add") {
      return;
    } else {
      ProductService.getProductById(this.state.id).then((res) => {
        let product = res.data;
        this.setState({
          nom: product.nom,
          prixUnitaire: product.prixUnitaire,
          quantite: product.quantite,
        });
      });
    }
  }
  saveOrUpdateProduct = (e) => {
    e.preventDefault();
    let product = {
      nom: this.state.nom,
      prixUnitaire: this.state.prixUnitaire,
      quantite: this.state.quantite,
    };
    console.log("product => " + JSON.stringify(product));

    if (this.state.id === "_add") {
      ProductService.createProduct(product).then((res) => {
        this.props.history.push("/products");
      });
    } else {
      ProductService.updateProduct(product, this.state.id).then((res) => {
        this.props.history.push("/products");
      });
    }
  };

  changeNomHandler = (event) => {
    this.setState({ nom: event.target.value });
  };

  changePrixUnitaireHandler = (event) => {
    this.setState({ prixUnitaire: event.target.value });
  };

  changeQuantiteHandler = (event) => {
    this.setState({ quantite: event.target.value });
  };

  getTitle() {
    if (this.state.id === "_add") {
      return <h3 className="text-center">Ajouter Produit</h3>;
    } else {
      return <h3 className="text-center">Modifier Produit</h3>;
    }
  }
  render() {
    return (
      <div>
        <br></br>
        <div className="container">
          <div className="row">
            <div className="card col-md-6 offset-md-3 offset-md-3">
              {this.getTitle()}
              <div className="card-body">
                <form>
                  <div className="form-group">
                    <label> Nom : </label>
                    <input
                      placeholder="Nom"
                      name="nom"
                      className="form-control"
                      value={this.state.nom}
                      onChange={this.changeNomHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Prix Unitaire : </label>
                    <input
                      placeholder="Prix Unitaire"
                      name="prixUnitaire"
                      className="form-control"
                      value={this.state.prixUnitaire}
                      onChange={this.changePrixUnitaireHandler}
                    />
                  </div>
                  <div className="form-group">
                    <label> Quantité : </label>
                    <input
                      placeholder="Quantité"
                      name="quantite"
                      className="form-control"
                      value={this.state.quantite}
                      onChange={this.changeQuantiteHandler}
                    />
                  </div>

                  <button
                    className="btn btn-success"
                    onClick={this.saveOrUpdateProduct}
                  >
                    Save
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default NewProduct;
