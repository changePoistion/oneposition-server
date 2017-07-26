package com.shopin.oneposition.bean.app;

import java.util.List;

import com.shopin.oneposition.bean.MovieListBean;

/**
 * @author changePosition
 * @date 2017年7月10日 下午2:18:17
 * @DESC
 */
public class MovieNostalgiaBean extends BaseEntity {
	private List<MovieListBean> movies;

	public List<MovieListBean> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieListBean> movies) {
		this.movies = movies;
	}

}
