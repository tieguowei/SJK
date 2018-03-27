package com.resale.background.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.StorePath;
import com.resale.background.mapper.CategoryMapper;
import com.resale.background.mapper.ProductMapper;
import com.resale.background.pojo.Category;
import com.resale.background.pojo.Merchant;
import com.resale.background.pojo.Product;
import com.resale.background.service.ProductService;
import com.resale.background.util.FdfsClient;
import com.resale.background.util.PageModel;
import com.resale.util.StringUtil;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private FdfsClient dfsClient;
	
	@Value("${fdfs.ip}")
	private String ip;
	
	@Override
	public PageModel getProductList(Map<String, Object> paramsCondition) {
		PageModel pageModel = new PageModel();
		pageModel.setPageNo((Integer) paramsCondition.get("pageNo"));
		pageModel.setPageSize((Integer) paramsCondition.get("pageSize"));
		paramsCondition.put("startIndex", pageModel.getStartIndex());
		paramsCondition.put("endIndex", pageModel.getEndIndex());
		List<Map<String, Object>> data = productMapper.findAllRetMapByPage(paramsCondition);
		for (Iterator iterator = data.iterator(); iterator.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			map.put("product_image_url", ip+map.get("product_image_url"));
		}
		Long totalRecords = productMapper.findAllByPageCount(paramsCondition);
		pageModel.setList(data);
		pageModel.setTotalRecords(totalRecords);
		return pageModel;
	}


	@Override
	public List<Category> getCategoryList(String merchantCode) {
		return categoryMapper.getCategoryList(merchantCode);
	}


	@Override
	public void saveProduct(Product product, MultipartFile fileField) throws IOException {
		Subject subject = SecurityUtils.getSubject();
		Merchant merchant = (Merchant) subject.getPrincipal();
		StorePath uploadFile = dfsClient.uploadFile(fileField);
		product.setProductImageUrl(uploadFile.getFullPath());
		product.setCreateTime(new Date());
		product.setMerchantCode(merchant.getMerchantCode());
		product.setStatus("1");
		productMapper.insert(product);
	}


	@Override
	public Product getProductById(int id) {
		return productMapper.selectByPrimaryKey(id);
	}


	@Override
	public void updateProduct(Product product, MultipartFile fileField) throws IOException {
		Product oldproduct = productMapper.selectByPrimaryKey(product.getId());
		String newFileName = fileField.getOriginalFilename();
		Subject subject = SecurityUtils.getSubject();
		Merchant merchant = (Merchant) subject.getPrincipal();
		//修改上传图片
		if(StringUtil.notBlank(newFileName)){
			dfsClient.deleteFile(oldproduct.getProductImageUrl());
			StorePath uploadFile = dfsClient.uploadFile(fileField);
			product.setProductImageUrl(uploadFile.getFullPath());
		}
		product.setUpdateTime(new Date());
		product.setStatus(oldproduct.getStatus());
		product.setSoldNum(oldproduct.getSoldNum());
		product.setMerchantCode(merchant.getMerchantCode());
		product.setCreateTime(oldproduct.getCreateTime());
		productMapper.updateByPrimaryKeySelective(product);
	}


	@Override
	public Product checkNameIsRepeat(Map<String, Object> map) {
		return productMapper.checkNameIsRepeat(map);
	}


	@Override
	public void deleteProduct(Product product) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", product.getId());
		map.put("status", "2");
		productMapper.deleteProductById(map);
	}




}
