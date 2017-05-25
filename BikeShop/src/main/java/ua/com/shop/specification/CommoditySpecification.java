package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.CommodityFilter;
import ua.com.shop.entity.Commodity;

public class CommoditySpecification implements Specification<Commodity> {

	private CommodityFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();

	private static final Pattern REG = Pattern
			.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

	public CommoditySpecification(CommodityFilter filter) {
		this.filter = filter;
		if (REG.matcher(filter.getMax()).matches()) {
			filter.setMaxValue(Double.valueOf(filter.getMax().replace(',', '.')));
		}
		if (REG.matcher(filter.getMin()).matches()) {
			filter.setMinValue(Double.valueOf(filter.getMin().replace(',', '.')));
		}
	}

	private void findByBrand(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getBrandId().isEmpty()) {
			predicates.add(root.get("brand").in(filter.getBrandId()));
		}
	}

	private void findByMaterial(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getMaterialId().isEmpty()) {
			predicates.add(root.get("material").in(filter.getMaterialId()));
		}
	}

	private void findByColor(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getColorId().isEmpty()) {
			predicates.add(root.get("color").in(filter.getColorId()));
		}
	}

	private void findByCategory(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!filter.getCategoryId().isEmpty()) {
			predicates.add(root.get("category").in(filter.getCategoryId()));
		}
	}

	private void findByPrice(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (filter.getMaxValue() != 0) {
			predicates.add(cb.le(root.get("price"), filter.getMaxValue()));
		}
		if (filter.getMinValue() != 0) {
			predicates.add(cb.ge(root.get("price"), filter.getMinValue()));
		}
	}

	private void fetch(Root<Commodity> root, CriteriaQuery<?> query) {
		if (!query.getResultType().equals(Long.class)) {
			query.distinct(true);
			root.fetch("brand");
			root.fetch("material");
			root.fetch("color");
			root.fetch("category");
		}
	}

	@Override
	public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		findByBrand(root, query);
		findByMaterial(root, query);
		findByColor(root, query);
		findByCategory(root, query);
		findByPrice(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

}
