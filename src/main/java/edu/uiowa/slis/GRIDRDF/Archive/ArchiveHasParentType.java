package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveHasParentType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveHasParentType currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveHasParentType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			ArchiveHasParentIterator theArchiveHasParentIterator = (ArchiveHasParentIterator)findAncestorWithClass(this, ArchiveHasParentIterator.class);
			pageContext.getOut().print(theArchiveHasParentIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for hasParent tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for hasParent tag ");
		}
		return SKIP_BODY;
	}
}

