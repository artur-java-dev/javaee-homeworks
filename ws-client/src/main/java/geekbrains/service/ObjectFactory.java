
package geekbrains.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.geekbrains.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProduct_QNAME = new QName("http://service.geekbrains.ru/", "getProduct");
    private final static QName _GetProductByTitleResponse_QNAME = new QName("http://service.geekbrains.ru/", "getProductByTitleResponse");
    private final static QName _GetProductResponse_QNAME = new QName("http://service.geekbrains.ru/", "getProductResponse");
    private final static QName _GetProductByTitle_QNAME = new QName("http://service.geekbrains.ru/", "getProductByTitle");
    private final static QName _RemoveProduct_QNAME = new QName("http://service.geekbrains.ru/", "removeProduct");
    private final static QName _AddProduct_QNAME = new QName("http://service.geekbrains.ru/", "addProduct");
    private final static QName _AddCategoryResponse_QNAME = new QName("http://service.geekbrains.ru/", "addCategoryResponse");
    private final static QName _AddProductResponse_QNAME = new QName("http://service.geekbrains.ru/", "addProductResponse");
    private final static QName _RemoveProductResponse_QNAME = new QName("http://service.geekbrains.ru/", "removeProductResponse");
    private final static QName _GetProductsResponse_QNAME = new QName("http://service.geekbrains.ru/", "getProductsResponse");
    private final static QName _AddCategory_QNAME = new QName("http://service.geekbrains.ru/", "addCategory");
    private final static QName _GetAllProducts_QNAME = new QName("http://service.geekbrains.ru/", "getAllProducts");
    private final static QName _GetProducts_QNAME = new QName("http://service.geekbrains.ru/", "getProducts");
    private final static QName _GetAllProductsResponse_QNAME = new QName("http://service.geekbrains.ru/", "getAllProductsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.geekbrains.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetProduct }
     * 
     */
    public GetProduct createGetProduct() {
        return new GetProduct();
    }

    /**
     * Create an instance of {@link GetProductByTitleResponse }
     * 
     */
    public GetProductByTitleResponse createGetProductByTitleResponse() {
        return new GetProductByTitleResponse();
    }

    /**
     * Create an instance of {@link GetProductResponse }
     *
     */
    public GetProductResponse createGetProductResponse() {
        return new GetProductResponse();
    }

    /**
     * Create an instance of {@link GetProductByTitle }
     *
     */
    public GetProductByTitle createGetProductByTitle() {
        return new GetProductByTitle();
    }

    /**
     * Create an instance of {@link RemoveProduct }
     *
     */
    public RemoveProduct createRemoveProduct() {
        return new RemoveProduct();
    }

    /**
     * Create an instance of {@link AddProduct }
     *
     */
    public AddProduct createAddProduct() {
        return new AddProduct();
    }

    /**
     * Create an instance of {@link AddCategoryResponse }
     *
     */
    public AddCategoryResponse createAddCategoryResponse() {
        return new AddCategoryResponse();
    }

    /**
     * Create an instance of {@link AddProductResponse }
     *
     */
    public AddProductResponse createAddProductResponse() {
        return new AddProductResponse();
    }

    /**
     * Create an instance of {@link RemoveProductResponse }
     *
     */
    public RemoveProductResponse createRemoveProductResponse() {
        return new RemoveProductResponse();
    }

    /**
     * Create an instance of {@link GetProductsResponse }
     *
     */
    public GetProductsResponse createGetProductsResponse() {
        return new GetProductsResponse();
    }

    /**
     * Create an instance of {@link AddCategory }
     *
     */
    public AddCategory createAddCategory() {
        return new AddCategory();
    }

    /**
     * Create an instance of {@link GetAllProducts }
     *
     */
    public GetAllProducts createGetAllProducts() {
        return new GetAllProducts();
    }

    /**
     * Create an instance of {@link GetProducts }
     *
     */
    public GetProducts createGetProducts() {
        return new GetProducts();
    }

    /**
     * Create an instance of {@link GetAllProductsResponse }
     *
     */
    public GetAllProductsResponse createGetAllProductsResponse() {
        return new GetAllProductsResponse();
    }

    /**
     * Create an instance of {@link CategoryDTO }
     *
     */
    public CategoryDTO createCategoryDTO() {
        return new CategoryDTO();
    }

    /**
     * Create an instance of {@link ProductDTO }
     *
     */
    public ProductDTO createProductDTO() {
        return new ProductDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduct }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "getProduct")
    public JAXBElement<GetProduct> createGetProduct(GetProduct value) {
        return new JAXBElement<GetProduct>(_GetProduct_QNAME, GetProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductByTitleResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "getProductByTitleResponse")
    public JAXBElement<GetProductByTitleResponse> createGetProductByTitleResponse(GetProductByTitleResponse value) {
        return new JAXBElement<GetProductByTitleResponse>(_GetProductByTitleResponse_QNAME, GetProductByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "getProductResponse")
    public JAXBElement<GetProductResponse> createGetProductResponse(GetProductResponse value) {
        return new JAXBElement<GetProductResponse>(_GetProductResponse_QNAME, GetProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductByTitle }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "getProductByTitle")
    public JAXBElement<GetProductByTitle> createGetProductByTitle(GetProductByTitle value) {
        return new JAXBElement<GetProductByTitle>(_GetProductByTitle_QNAME, GetProductByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProduct }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "removeProduct")
    public JAXBElement<RemoveProduct> createRemoveProduct(RemoveProduct value) {
        return new JAXBElement<RemoveProduct>(_RemoveProduct_QNAME, RemoveProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProduct }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "addProduct")
    public JAXBElement<AddProduct> createAddProduct(AddProduct value) {
        return new JAXBElement<AddProduct>(_AddProduct_QNAME, AddProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCategoryResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "addCategoryResponse")
    public JAXBElement<AddCategoryResponse> createAddCategoryResponse(AddCategoryResponse value) {
        return new JAXBElement<AddCategoryResponse>(_AddCategoryResponse_QNAME, AddCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProductResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "addProductResponse")
    public JAXBElement<AddProductResponse> createAddProductResponse(AddProductResponse value) {
        return new JAXBElement<AddProductResponse>(_AddProductResponse_QNAME, AddProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProductResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "removeProductResponse")
    public JAXBElement<RemoveProductResponse> createRemoveProductResponse(RemoveProductResponse value) {
        return new JAXBElement<RemoveProductResponse>(_RemoveProductResponse_QNAME, RemoveProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductsResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "getProductsResponse")
    public JAXBElement<GetProductsResponse> createGetProductsResponse(GetProductsResponse value) {
        return new JAXBElement<GetProductsResponse>(_GetProductsResponse_QNAME, GetProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCategory }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "addCategory")
    public JAXBElement<AddCategory> createAddCategory(AddCategory value) {
        return new JAXBElement<AddCategory>(_AddCategory_QNAME, AddCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProducts }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "getAllProducts")
    public JAXBElement<GetAllProducts> createGetAllProducts(GetAllProducts value) {
        return new JAXBElement<GetAllProducts>(_GetAllProducts_QNAME, GetAllProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "getProducts")
    public JAXBElement<GetProducts> createGetProducts(GetProducts value) {
        return new JAXBElement<GetProducts>(_GetProducts_QNAME, GetProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.geekbrains.ru/", name = "getAllProductsResponse")
    public JAXBElement<GetAllProductsResponse> createGetAllProductsResponse(GetAllProductsResponse value) {
        return new JAXBElement<GetAllProductsResponse>(_GetAllProductsResponse_QNAME, GetAllProductsResponse.class, null, value);
    }

}
