/**
*
*/
    $(document).ready(function () {
                
     $('table tr #edit').click(function(){
  	    event.preventDefault();

  	      var href = $(this).attr('href');

    $.get(href, function (product) {
      $('#idEdit').val(product.id);
      $('#NameEdit').val(product.name);
      $('#BrandEdit').val(product.brand);
      $('#MadeinEdit').val(product.madein);
      $('#PriceEdit').val(product.price);
      });
    $("#editModal").modal('show'); 
  });
});

