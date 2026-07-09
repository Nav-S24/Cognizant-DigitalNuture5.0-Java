
public static int linearSearch(Product[] products,String name){

    for(int i=0;i<products.length;i++){

        if(products[i].productName.equals(name))
            return i;
    }

    return -1;
}
public static int binarySearch(Product[] products,String key){

    int low=0;
    int high=products.length-1;

    while(low<=high){

        int mid=(low+high)/2;

        int result=products[mid].productName.compareTo(key);

        if(result==0)
            return mid;

        else if(result<0)
            low=mid+1;

        else
            high=mid-1;
    }

    return -1;
}

public class Product {

    int productId;
    String productName;
    String category;

    public Product(int id,String name,String category){

        this.productId=id;
        this.productName=name;
        this.category=category;
    }
}