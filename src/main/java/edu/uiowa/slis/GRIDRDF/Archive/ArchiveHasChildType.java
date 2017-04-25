package edu.uiowa.slis.GRIDRDF.Archive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

@SuppressWarnings("serial")
public class ArchiveHasChildType extends edu.uiowa.slis.GRIDRDF.TagLibSupport {
	static ArchiveHasChildType currentInstance = null;
	private static final Log log = LogFactory.getLog(ArchiveHasChildType.class);

	// object property

	public int doStartTag() throws JspException {
		try {
			ArchiveHasChildIterator theArchiveHasChildIterator = (ArchiveHasChildIterator)findAncestorWithClass(this, ArchiveHasChildIterator.class);
			pageContext.getOut().print(theArchiveHasChildIterator.getType());
		} catch (Exception e) {
			log.error("Can't find enclosing Archive for hasChild tag ", e);
			throw new JspTagException("Error: Can't find enclosing Archive for hasChild tag ");
		}
		return SKIP_BODY;
	}
}

