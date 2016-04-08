package org.prateek.demoproject.demoproject.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class BusinessAttributesList {



		ArrayList<String> attributeList;

		public ArrayList<String> getAttributeList() {
			return attributeList;
		}

		public void setAttributeList(ArrayList<String> attributeList) {
			this.attributeList = attributeList;
		}

		/**
		 * @param attributeList
		 */
		public BusinessAttributesList(ArrayList<String> attributeList) {
			super();
			this.attributeList = attributeList;
		}

		/**
		 * @param attributeList
		 */
		public BusinessAttributesList() {
			this.attributeList = attributeList;
		}


}
